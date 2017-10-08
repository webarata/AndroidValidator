package link.webarata3.dro.common.validator7;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import link.webarata3.dro.common.util7.enums.LineBreakType;
import link.webarata3.dro.common.validator7.enums.TrimType;
import link.webarata3.dro.common.validator7.enums.UseEmBlank;
import link.webarata3.dro.common.validator7.enums.UseLineBreak;
import link.webarata3.dro.common.validator7.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class EmKatakanaValidatorTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    private Context mockContext;

    private static final int VALIDATOR_MESSAGE_ID = link.webarata3.dro.common.validator7.R.string.validator_emKatakana;

    @Test
    public void EmKatakanaValidatorでtestの場合() {
        final String expectedMessage = "全角カタカナで入力してください";
        when(mockContext.getString(R.string.validator_emKatakana)).thenReturn(expectedMessage);

        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(mockContext, validationHelper, "test"), is(expectedMessage));
    }

    @Test
    public void EmKatakanaValidatorでアイウエオの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(mockContext, validationHelper, "アイウエオ"), is(nullValue()));
    }

    @Test
    public void EmKatakanaValidatorでアイウエオ全角ブランクの場合() {
        final String expectedMessage = "全角カタカナで入力してください";
        when(mockContext.getString(R.string.validator_emKatakana)).thenReturn(expectedMessage);

        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(mockContext, validationHelper, "アイウエ　オ"), is(expectedMessage));
    }

    @Test
    public void EmKatakanaValidatorでアイウエ全角ブランクオで全角ブランクを許可の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.ALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(mockContext, validationHelper, "アイウエ　オ"), is(nullValue()));
    }

    @Test
    public void EmKatakanaValidatorでアイウエ改行オで改行を許可の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.ALLOW);
        assertThat(validator.validate(mockContext, validationHelper, "アイウエ\r\nオ"), is(nullValue()));
    }

}

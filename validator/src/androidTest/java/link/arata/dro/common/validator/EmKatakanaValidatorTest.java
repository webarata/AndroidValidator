package link.arata.dro.common.validator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import link.arata.common.enums.LineBreakType;
import link.arata.common.enums.TrimType;
import link.arata.common.enums.UseEmBlank;
import link.arata.common.enums.UseLineBreak;
import link.arata.common.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class EmKatakanaValidatorTest {
    private Context context;

    private static final int VALIDATOR_MESSAGE_ID = R.string.validator_emKatakana;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void EmKatakanaValidatorでtestの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(context, validationHelper, "test"), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }

    @Test
    public void EmKatakanaValidatorでアイウエオの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(context, validationHelper, "アイウエオ"), is(nullValue()));
    }

    @Test
    public void EmKatakanaValidatorでアイウエ全角ブランクオの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(context, validationHelper, "アイウエ　オ"), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }

    @Test
    public void EmKatakanaValidatorでアイウエ全角ブランクオで全角ブランクを許可の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new EmKatakanaValidator(UseEmBlank.ALLOW, UseLineBreak.DISALLOW);
        assertThat(validator.validate(context, validationHelper, "アイウエ　オ"), is(nullValue()));
    }
}

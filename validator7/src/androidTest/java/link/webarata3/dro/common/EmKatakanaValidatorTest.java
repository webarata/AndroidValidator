package link.webarata3.dro.common;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import link.webarata3.dro.common.enums.LineBreakType;
import link.webarata3.dro.common.validator.EmKatakanaValidator;
import link.webarata3.dro.common.validator.Validator;
import link.webarata3.dro.common.validator.enums.TrimType;
import link.webarata3.dro.common.validator.enums.UseEmBlank;
import link.webarata3.dro.common.validator.enums.UseLineBreak;
import link.webarata3.dro.common.validator.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class EmKatakanaValidatorTest {

    @RunWith(AndroidJUnit4.class)
    public static class EmKatakanaValidatorのテスト {
        private Context context;

        private static final int VALIDATOR_MESSAGE_ID = link.arata.dro.common.validator.R.string.validator_emKatakana;

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

        @Test
        public void EmKatakanaValidatorでアイウエ改行オで改行を許可の場合() {
            ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
            Validator validator = new EmKatakanaValidator(UseEmBlank.DISALLOW, UseLineBreak.ALLOW);
            assertThat(validator.validate(context, validationHelper, "アイウエ\r\nオ"), is(nullValue()));
        }
    }
}

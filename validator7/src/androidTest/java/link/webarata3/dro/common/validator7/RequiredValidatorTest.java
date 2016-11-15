package link.webarata3.dro.common.validator7;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import link.webarata3.dro.common.util7.enums.LineBreakType;
import link.webarata3.dro.common.validator7.enums.TrimType;
import link.webarata3.dro.common.validator7.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class RequiredValidatorTest {
    private Context context;

    private static final int VALIDATOR_MESSAGE_ID = link.webarata3.dro.common.validator7.R.string.validator_required;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void requiredValidatorでtestの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(context, validationHelper, "test"), is(nullValue()));
    }

    @Test
    public void requiredValidatorで空文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(context, validationHelper, ""), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }

    @Test
    public void requiredValidatorで空白文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(context, validationHelper, " \r\n\t"), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }

    @Test
    public void requiredValidatorでtrimをNONEにして空白文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(context, validationHelper, " \r\n\t"), is(nullValue()));
    }
}

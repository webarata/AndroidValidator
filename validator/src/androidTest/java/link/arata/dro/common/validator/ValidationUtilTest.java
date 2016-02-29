package link.arata.dro.common.validator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import link.arata.common.enums.LineBreakType;
import link.arata.common.enums.TrimType;
import link.arata.common.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ValidationUtilTest {
    private Context context;

    private static final int VALIDATOR_MESSAGE_ID = R.string.validator_required;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void requiredValidatorでtestの場合() {
        Validator validator = new RequiredValidator(ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF));
        assertThat(ValidatorUtil.validate(context, "test", validator), is(nullValue()));
    }

    @Test
    public void requiredValidatorで空文字の場合() {
        Validator validator = new RequiredValidator(ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF));
        assertThat(ValidatorUtil.validate(context, "", validator), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }

    @Test
    public void validatorTextViewでtestの場合() {
        TextView textView = new TextView(context);
        textView.setText("test");
        Validator validator = new RequiredValidator(ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF));
        assertThat(ValidatorUtil.validateEditText(context, textView, validator), is(true));
        assertThat(textView.getError(), is(nullValue()));
    }

    @Test
    public void validatorTextViewで空文字の場合() {
        TextView textView = new TextView(context);
        textView.setText("");
        Validator validator = new RequiredValidator(ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF));
        assertThat(ValidatorUtil.validateEditText(context, textView, validator), is(false));
        assertThat(textView.getError().toString(), is(context.getString(VALIDATOR_MESSAGE_ID)));
    }
}

package link.webarata3.dro.common.validator7;

import android.content.Context;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import link.webarata3.dro.common.util7.enums.LineBreakType;
import link.webarata3.dro.common.validator7.enums.TrimType;
import link.webarata3.dro.common.validator7.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class ValidatorUtilTest {
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    private Context mockContext;

    @Mock
    private TextView mockTextView;

    @Test
    public void requiredValidatorでtestの場合() {
        Validator validator = new RequiredValidator();
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        assertThat(ValidatorUtil.validate(mockContext, validationHelper, "test", validator), is(nullValue()));
    }

    @Test
    public void requiredValidatorで空文字の場合() {
        final String expectedMessage = "入力してください";
        when(mockContext.getString(R.string.validator_required)).thenReturn(expectedMessage);

        Validator validator = new RequiredValidator();
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        assertThat(ValidatorUtil.validate(mockContext, validationHelper, "", validator), is(expectedMessage));
    }

    @Test
    public void validatorTextViewでtestの場合() {
        when(mockTextView.getText()).thenReturn("test");

        Validator validator = new RequiredValidator();
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        assertThat(ValidatorUtil.validateEditText(mockContext, validationHelper, mockTextView, validator), is(true));
        assertThat(mockTextView.getError(), is(nullValue()));
    }

    @Test
    public void validatorTextViewで空文字の場合() {
        final String expectedMessage = "入力してください";
        when(mockContext.getString(R.string.validator_required)).thenReturn(expectedMessage);

        when(mockTextView.getText()).thenReturn("");
        when(mockTextView.getError()).thenReturn(expectedMessage);

        Validator validator = new RequiredValidator();
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        assertThat(ValidatorUtil.validateEditText(mockContext, validationHelper, mockTextView, validator), is(false));
        assertThat(mockTextView.getError().toString(), is(expectedMessage));
    }
}

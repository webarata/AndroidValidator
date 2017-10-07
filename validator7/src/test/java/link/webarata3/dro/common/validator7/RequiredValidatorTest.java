package link.webarata3.dro.common.validator7;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import link.webarata3.dro.common.util7.enums.LineBreakType;
import link.webarata3.dro.common.validator7.enums.TrimType;
import link.webarata3.dro.common.validator7.helper.ValidationHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RequiredValidatorTest {
    @Mock
    private Context mockContext;

    private static final int VALIDATOR_MESSAGE_ID = link.webarata3.dro.common.validator7.R.string.validator_required;

    @Test
    public void requiredValidatorでtestの場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(mockContext, validationHelper, "test"), is(nullValue()));
    }

    @Test
    public void requiredValidatorで空文字の場合() {
        final String expectedMessage = "入力してください";
        when(mockContext.getString(R.string.validator_required)).thenReturn(expectedMessage);

        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(mockContext, validationHelper, ""), is(expectedMessage));
    }

    @Test
    public void requiredValidatorで空白文字の場合() {
        final String expectedMessage = "入力してください";
        when(mockContext.getString(R.string.validator_required)).thenReturn(expectedMessage);

        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(mockContext, validationHelper, " \r\n\t"), is(expectedMessage));
    }

    @Test
    public void requiredValidatorでtrimをNONEにして空白文字の場合() {
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.NONE, LineBreakType.LF);
        Validator validator = new RequiredValidator();
        assertThat(validator.validate(mockContext, validationHelper, " \r\n\t"), is(nullValue()));
    }
}

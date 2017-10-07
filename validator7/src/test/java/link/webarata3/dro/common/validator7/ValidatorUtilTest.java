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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorUtilTest {
    @Mock
    private Context mockContext;

    @Test
    public void test() {
        when(mockContext.getString(R.string.validator_required)).thenReturn("入力してください");

        Validator validator = new RequiredValidator();
        ValidationHelper validationHelper = ValidationHelper.getInstance(TrimType.RIGHT, LineBreakType.LF);
        assertThat(ValidatorUtil.validate(mockContext, validationHelper, "", validator), is("入力してください"));
    }
}

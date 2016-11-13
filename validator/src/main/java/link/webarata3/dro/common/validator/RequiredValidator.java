package link.webarata3.dro.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import link.arata.dro.common.validator.R;
import link.webarata3.dro.common.validator.helper.ValidationHelper;


/***
 * 必須Validator
 *
 * @author arata
 */
public class RequiredValidator implements Validator {
    private static final int DEFAULT_MESSAGE_ID = R.string.validator_required;

    /**
     * 空文字華道家のチェック。<br>
     * デフォルトか、コンストラクタで指定したtrimをした後にチェックされる
     *
     * @param context          コンテキスト
     * @param validationHelper 必須のチェックに使用されるhelper
     * @param value            バリデーション対象の文字列
     * @return 空文字の場合false
     */
    @Nullable
    @Override
    public String validate(@NonNull Context context, @NonNull ValidationHelper validationHelper, @NonNull String value) {
        if (validationHelper.required(value)) {
            return null;
        }
        return context.getText(DEFAULT_MESSAGE_ID).toString();
    }
}

package link.arata.dro.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import link.arata.common.helper.ValidationHelper;

/***
 * 必須Validator
 *
 * @author arata
 */
public class RequiredValidator implements Validator {
    private static final int DEFAULT_MESSAGE_ID = R.string.validator_required;

    private ValidationHelper validationHelper;

    /**
     * 指定したhelperを用いるコンストラクタ
     *
     * @param validationHelper 必須のチェックに使用されるhelper
     */
    public RequiredValidator(@NonNull ValidationHelper validationHelper) {
        this.validationHelper = validationHelper;
    }

    /**
     * 空文字華道家のチェック。<br>
     * デフォルトか、コンストラクタで指定したtrimをした後にチェックされる
     *
     * @param context コンテキスト
     * @param value   バリデーション対象の文字列
     * @return 空文字の場合false
     */
    @Nullable
    @Override
    public String validate(@NonNull Context context, @NonNull String value) {
        if (validationHelper.required(value)) {
            return null;
        }
        return context.getText(DEFAULT_MESSAGE_ID).toString();
    }
}

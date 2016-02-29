package link.arata.dro.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Validatorを使うためのユーティリティ
 *
 * @author arata
 */
public abstract class ValidatorUtil {
    /**
     * textをvalidatorsでチェックする。<br>
     * 最初に見つかったエラーを返す。<br>
     * validationにすべて成功した場合にはnullを返す
     *
     * @param context    コンテキスト
     * @param value      検査するテキスト
     * @param validators textを検査するValidator
     * @return エラーメッセージ。なければnull
     */
    @Nullable
    public static String validate(@NonNull Context context, @NonNull String value, @NonNull Validator... validators) {
        String message = null;
        for (Validator validator : validators) {
            message = validator.validate(context, value);
            if (message != null) {
                break;
            }
        }
        return message;
    }

    /**
     * EditTextのValidationをする。<br>
     * エラーが有った場合にはEditTextにエラーをセットし、falseを返す。
     *
     * @param context    コンテキスト
     * @param textView   検査するTextView
     * @param validators EditTextを検査するValidator
     * @return エラーの場合false
     */
    public static boolean validateEditText(@NonNull Context context, @NonNull TextView textView, @NonNull Validator... validators) {
        String message = validate(context, textView.getText().toString(), validators);
        if (message == null) {
            return true;
        }
        textView.setError(message);
        return false;
    }
}

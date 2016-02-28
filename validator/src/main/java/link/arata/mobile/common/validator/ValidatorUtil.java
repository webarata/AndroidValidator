package link.arata.mobile.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
}

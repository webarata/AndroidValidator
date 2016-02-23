package link.arata.android.common.validator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Validatorインターフェース
 * @author arata
 */
public interface Validator {
    /**
     * バリデーションする
     * @param value バリデーション対象の文字列
     * @return エラーの場合エラーメッセージを返す。エラーでない場合nullを返す。
     */
    @Nullable
    String validate(@NonNull String value);
}

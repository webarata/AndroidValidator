package link.arata.dro.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import link.arata.common.helper.ValidationHelper;

/**
 * Validatorインターフェース
 *
 * @author arata
 */
public interface Validator {
    /**
     * バリデーションする
     *
     * @param context コンテキスト
     * @param validationHelper 必須のチェックに使用されるhelper
     * @param value   バリデーション対象の文字列
     * @return エラーの場合エラーメッセージを返す。エラーでない場合nullを返す。
     */
    @Nullable
    String validate(@NonNull Context context, @NonNull ValidationHelper validationHelper, @NonNull String value);
}

package link.arata.android.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import link.arata.common.util.TrimType;
import link.arata.common.util.ValidationUtil;

/***
 * 必須Validator
 *
 * @author arata
 */
public class RequiredValidator implements Validator {
    /**
     * デフォルトのTrimType
     */
    public static TrimType DEFAULT_TRIM_TYPE = TrimType.RIGHT;

    private static final int  DEFAULT_MESSAGE_ID = R.string.validator_required;

    private TrimType trimType;
    private Context context;

    /**
     * デフォルトのtrimを行うコンストラクタ
     * @param context コンテキスト
     */
    public RequiredValidator(@NonNull Context context) {
        this(context, DEFAULT_TRIM_TYPE);
    }

    /**
     * 指定したtrimを行うコンストラクタ
     *
     * @param context コンテキスト
     * @param trimType 必須のチェックの前に行うtrim
     */
    public RequiredValidator(@NonNull Context context, @NonNull TrimType trimType) {
        this.context = context;
        this.trimType = trimType;
    }

    /**
     * 空文字華道家のチェック。<br>
     * デフォルトか、コンストラクタで指定したtrimをした後にチェックされる
     *
     * @param value バリデーション対象の文字列
     * @return 空文字の場合false
     */
    @Nullable
    @Override
    public String validate(@NonNull String value) {

        if (ValidationUtil.required(value, trimType)) {
            return null;
        }
        return context.getText(DEFAULT_MESSAGE_ID).toString();
    }
}

package link.webarata3.dro.common.validator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import link.arata.dro.common.validator.R;
import link.webarata3.common.enums.UseEmBlank;
import link.webarata3.common.enums.UseLineBreak;
import link.webarata3.common.helper.ValidationHelper;

/***
 * 必須Validator
 *
 * @author arata
 */
public class EmKatakanaValidator implements Validator {
    private static final int DEFAULT_MESSAGE_ID = R.string.validator_emKatakana;

    /** 全角ブランクを許可するか */
    private UseEmBlank useEmBlank;
    /** 改行を許可するか */
    private UseLineBreak useLineBreak;

    /**
     * コンストラクタ
     * @param useEmBlank 全角ブランクも許可する
     * @param useLineBreak 改行も許可する
     */
    public EmKatakanaValidator(UseEmBlank useEmBlank, UseLineBreak useLineBreak) {
        this.useEmBlank = useEmBlank;
        this.useLineBreak = useLineBreak;
    }

    /**
     * 空文字華道家のチェック。<br>
     * デフォルトか、コンストラクタで指定したtrimをした後にチェックされる
     *
     * @param context          コンテキスト
     * @param validationHelper 必須のチェックに使用されるhelper
     * @param value            バリデーション対象の文字列
     * @return エラーがない場合nullを返し、エラーが有る場合にはエラーメッセージを返す
     */
    @Nullable
    @Override
    public String validate(@NonNull Context context, @NonNull ValidationHelper validationHelper, @NonNull String value) {
        if (validationHelper.isEmKatakana(value, useEmBlank, useLineBreak)) {
            return null;
        }
        return context.getText(DEFAULT_MESSAGE_ID).toString();
    }
}

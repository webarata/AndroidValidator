package link.webarata3.dro.common.validator7.enums;


import android.support.annotation.NonNull;

import link.webarata3.dro.common.util7.StringUtil;

/**
 * trimの方向を決めるenum
 *
 * @author webarata3
 */
public enum TrimType {
    NONE {
        @Override
        public String trim(@NonNull String value) {
            return value;
        }
    }, BOTH {
        @Override
        public String trim(@NonNull String value) {
            return StringUtil.trim(value);
        }
    }, LEFT {
        @Override
        public String trim(@NonNull String value) {
            return StringUtil.trimLeft(value);
        }
    }, RIGHT {
        @Override
        public String trim(@NonNull String value) {
            return StringUtil.trimRight(value);
        }
    };

    /**
     * 指定のtrimをかける
     *
     * @param value trim対象の文字列
     * @return trimした文字列
     */
    public abstract String trim(@NonNull String value);
}

package com.gavinandre.typesystem

fun testNullable1(x: String, y: String?): Int {
    return x.length
}

/**
 * 等价于
 * @Nullable
 * public static final Integer testNullable2(@NotNull String x, @Nullable String y) {
 *    Intrinsics.checkParameterIsNotNull(x, "x");
 *    return y != null ? y.length() : null;
 * }
 */
fun testNullable2(x: String, y: String?): Int? {
    return y?.length
}

/**
 * 等价于
 * @Nullable
 * public static final Integer testNullable3(@NotNull String x, @Nullable String y) {
 *    Intrinsics.checkParameterIsNotNull(x, "x");
 *    if (y == null) {
 *       Intrinsics.throwNpe();
 *    }
 *    return y.length();
 * }
 */
fun testNullable3(x: String, y: String?): Int? {
    return y!!.length
}

fun nullPlus() {
    null.plus(null)
}
package org.swordess.javamisc.io;

public class ArrayUtil {

	/**
	 * Compare the equality of the provided <code>src</code> byte array and
	 * <code>dest</code> byte array.
	 * <p>
	 * The comparison will begin at the start point of the provided array. The
	 * start points of the <code>src</code> and <code>dest</code> array are
	 * specified by the <code>srcOffset</code> and <code>destOffset</code>,
	 * respectively. The number of elements to be compared is specified by the
	 * <code>length</code>.
	 * <p>
	 * Note that two <tt>null</tt> arrays are considered equal, but of only one
	 * of them is <tt>null</tt> while the other one is not <tt>null</tt> are
	 * considered not equal.
	 * 
	 * @param src
	 *            the source array, can be null
	 * @param srcOffset
	 *            the start point of the source array, inclusive
	 * @param dest
	 *            the destination array, can be null
	 * @param destOffset
	 *            the start point of the destination array, inclusive
	 * @param length
	 *            the number of elements to be compared
	 * @return <tt>true</tt> if the two arrays are equal
	 * @throws ArrayIndexOutOfBoundsException
	 *             if {@literal srcOffset < 0 || srcOffset >= src.length} or
	 *             {@literal destOffset < 0 || destOffset >= dest.length}
	 * @throws IllegalArgumentException
	 *             if {@literal length < 0} or
	 *             {@literal srcOffset + length > src.length} or
	 *             {@literal destOffset + length > dest.length}
	 */
	public static boolean equals(byte[] src, int srcOffset,
			byte[] dest, int destOffset, int length) {
		
		if (null == src && null == dest) {
			return true;
		}
		
		if (null == src || null == dest) {
			return false;
		}

		if (srcOffset < 0 || srcOffset >= src.length) {
			throw new ArrayIndexOutOfBoundsException(srcOffset);
		}
		if (destOffset < 0 || destOffset >= dest.length) {
			throw new ArrayIndexOutOfBoundsException(destOffset);
		}
		
		if (srcOffset + length > src.length) {
			throw new IllegalArgumentException(
					"length exceed the upper bounds of src when starting from the offset "
							+ srcOffset);
		}
		if (destOffset + length > dest.length) {
			throw new IllegalArgumentException(
					"length exceed the upper bounds of dest when starting from the offset "
							+ destOffset);
		}
		
		for (int i = 0; i < length; i++) {
			if (!(src[srcOffset + i] == dest[destOffset + i])) {
				return false;
			}
		}
		return true;
	}
	
	private ArrayUtil() {
	}
	
}

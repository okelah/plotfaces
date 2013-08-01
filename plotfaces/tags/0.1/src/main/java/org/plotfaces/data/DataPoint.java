/*
 * Copyright 2013 Graham Smith.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.plotfaces.data;

import java.util.Objects;

/**
 * <p>NOTE: The value is typically expected to be a one of the subclasses of
 * {@code Number} but that is not enforced since it is possible some graphs may
 * accept non-numeric values. Additionally if the value was forced to be a
 * subclass of {@code Number} applying a natural order would become difficult
 * since Number itself doesn't implement Comparable<Number> as it doesn't make
 * sense to try and compare, for example, a Double and an Integer.</p>
 *
 * @param <K>
 * @param <V>
 * @author Graham Smith
 */
public class DataPoint<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<DataPoint<K, V>> {

	private K key;
	private V value;

	/**
	 *
	 * @param key a non-null key for this {@code DataPoint}
	 * @param value a non-null value for this {@code DataPoint}
	 */
	public DataPoint(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Both the key and value must be non-null");
		}
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	/**
	 *
	 * @param key a non-null key for this {@code DataPoint}
	 */
	public void setKey(K key) {
		if (key == null) {
			throw new IllegalArgumentException("The key must be non-null");
		}
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	/**
	 *
	 * @param value a non-null value for this {@code DataPoint}
	 */
	public void setValue(V value) {
		if (value == null) {
			throw new IllegalArgumentException("The value must be non-null");
		}
		this.value = value;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + Objects.hashCode(this.key);
		hash = 59 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DataPoint<K, V> other = (DataPoint<K, V>) obj;
		if (!Objects.equals(this.key, other.key)) {
			return false;
		}
		if (!Objects.equals(this.value, other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(DataPoint<K, V> dp) {
		int result = key.compareTo(dp.key);
		if (result != 0) {
			return result;
		}

		return value.compareTo(dp.value);
	}
}

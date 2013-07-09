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

import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * <p>Represents data for a single series. The type of data must match that
 * being displayed in the series, no effort is made to ensure that the data is
 * of the correct type. The key and value must implement {@code Comparable} so
 * that the data can be naturally ordered if required. Under some circumstances
 * jqPlot will attempt to sort the data if required but it's almost certainly
 * faster to sort it here if sorted data is needed.</p>
 *
 * <p>Optionally a {@code Format} can be supplied to format the key values. This
 * is particularly useful (probably necessary) with date based data. Every key
 * will be formatted if a format is specified. It is the users responsibility to
 * ensure that all key values can be formatted with the given Format.</p>
 *
 * <p>A {@code Comparator} can be supplied which will be used to sort the data.
 * If no Comparator is supplied and sort is called the {@code DataPoint}s will
 * be sorted according to their natural order. If sort is not called the data
 * will be ordered as presented.</p>
 *
 * <p>If a simple array is required setting the encodeKey flag to false will
 * cause the encode method to skip the keys. Every data point must still have a
 * key even if they aren't going to be encoded. If sorting is required then
 * making all the keys the same should ensure that the sort works as expected.
 * It recommended that the NULL_KEY constant is supplied as the key for every
 * data point to ensure that the data points sort correctly.</p>
 *
 * @param <K> key type
 * @param <V> value type
 * @author Graham Smith
 */
public class PlotData<K extends Comparable<K>, V extends Comparable<V>> {

	public static final String NULL_KEY = "";
	private List<DataPoint<K, V>> dataPoints = new ArrayList<>();
	private Format format;
	private Comparator comparator;
	private boolean encodeKeys = true;

	public PlotData() {
	}

	public List<DataPoint<K, V>> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(List<DataPoint<K, V>> dataPoints) {
		this.dataPoints = dataPoints;
	}

	public void add(DataPoint<K, V> dataPoint) {
		this.dataPoints.add(dataPoint);
	}

	/**
	 * Adds a new data point to the end of the list of data points.
	 *
	 * @param key a non-null key for a new {@code DataPoint}
	 * @param value a non-null value for a new {@code DataPoint}
	 */
	public void add(K key, V value) {
		this.dataPoints.add(new DataPoint<>(key, value));
	}

	/**
	 *
	 */
	public void sort() {
		if (getComparator() != null) {
			Collections.sort(dataPoints, getComparator());
		} else {
			Collections.sort(dataPoints);
		}
	}

	/**
	 * <p>Produces an array of data points suitable for use in jqPlot or more
	 * generally in any JavaScript application.
	 * <p>The format for data with encodeKeys set to true is:
	 * [[x1,y1],[x2,y2],...]</p>
	 * <p>The format for data with encodeKeys set to false is:
	 * [y1,y2,y3,...]</p>
	 * <p>If the key or value is a number it is output as a number all other
	 * types of key and value are output enclosed in single quotes (no attempt
	 * is currently made to escape the data).</p>
	 *
	 *
	 * @return
	 */
	public String encode() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		String key;
		for (DataPoint dp : dataPoints) {
			if (isEncodeKeys()) {
				key = String.valueOf(dp.getKey());
				//If we have a format set use that to get the basic key rather
				//than the simple string value of.
				if (getFormat() != null) {
					key = getFormat().format(dp.getKey());
				}

				if (!(dp.getKey() instanceof Number)) {
					key = "'" + key + "'";
				}

				builder.append("[");
				builder.append(key);
				builder.append(",");
			}

			if (dp.getValue() instanceof Number) {
				builder.append(dp.getValue());
			} else {
				builder.append("'");
				builder.append(dp.getValue());
				builder.append("'");
			}


			if (isEncodeKeys()) {
				builder.append("]");
			}
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Comparator getComparator() {
		return comparator;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	public boolean isEncodeKeys() {
		return encodeKeys;
	}

	public void setEncodeKeys(boolean encodeKeys) {
		this.encodeKeys = encodeKeys;
	}
}

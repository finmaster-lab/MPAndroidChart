
package com.github.mikephil.charting.data;

import java.util.Arrays;
import java.util.List;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

/**
 * Data container for the RadarChart.
 *
 * @author Philipp Jahoda
 */
public class RadarData extends ChartData<IRadarDataSet> {

	private List<String> mLabels;

	public RadarData() {
		super();
	}

	public RadarData(List<IRadarDataSet> dataSets) {
		super(dataSets);
	}

	public RadarData(IRadarDataSet... dataSets) {
		super(dataSets);
	}

	public List<String> getLabels() {
		return mLabels;
	}

	/**
	 * Sets the labels that should be drawn around the RadarChart at the end of
	 * each web line.
	 *
	 * @param labels
	 */
	public void setLabels(List<String> labels) {
		this.mLabels = labels;
	}

	/**
	 * Sets the labels that should be drawn around the RadarChart at the end of
	 * each web line.
	 *
	 * @param labels
	 */
	public void setLabels(String... labels) {
		this.mLabels = Arrays.asList(labels);
	}

	@Override
	public Entry getEntryForHighlight(Highlight highlight) {
		return getDataSetByIndex(highlight.getDataSetIndex())
				.getEntryForIndex((int) highlight.getX());
	}
}

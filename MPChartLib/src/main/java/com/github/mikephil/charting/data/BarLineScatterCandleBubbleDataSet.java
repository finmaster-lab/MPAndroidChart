
package com.github.mikephil.charting.data;

import java.util.List;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;

import android.graphics.Color;

/**
 * Baseclass of all DataSets for Bar-, Line-, Scatter- and CandleStickChart.
 *
 * @author Philipp Jahoda
 */
public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry>
		extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {

	/**
	 * default highlight color
	 */
	protected int mHighLightColor = Color.rgb(255, 187, 115);

	public BarLineScatterCandleBubbleDataSet(List<T> yVals, String label) {
		super(yVals, label);
	}

	@Override
	public int getHighLightColor() {
		return mHighLightColor;
	}

	/**
	 * Sets the color that is used for drawing the highlight indicators. Dont
	 * forget to resolve the color using getResources().getColor(...) or
	 * Color.rgb(...).
	 *
	 * @param color
	 */
	public void setHighLightColor(int color) {
		mHighLightColor = color;
	}

	protected void copy(
			BarLineScatterCandleBubbleDataSet barLineScatterCandleBubbleDataSet) {
		super.copy(barLineScatterCandleBubbleDataSet);
		barLineScatterCandleBubbleDataSet.mHighLightColor = mHighLightColor;
	}
}

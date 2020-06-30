
package com.github.mikephil.charting.charts;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.LineChartRenderer;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Chart that draws lines, surfaces, circles, ...
 *
 * @author Philipp Jahoda
 */
public class LineChart extends BarLineChartBase<LineData>
		implements LineDataProvider {
	// 是否强制拖拽高亮线模式
	private boolean forceDragHighlightMode = false;
	public LineChart(Context context) {
		super(context);
	}

	public LineChart(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LineChart(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void init() {
		super.init();

		mRenderer = new LineChartRenderer(this, mAnimator, mViewPortHandler);
	}

	@Override
	public LineData getLineData() {
		return mData;
	}

	@Override
	protected void onDetachedFromWindow() {
		// releases the bitmap in the renderer to avoid oom error
		if (mRenderer != null && mRenderer instanceof LineChartRenderer) {
			((LineChartRenderer) mRenderer).releaseBitmap();
		}
		super.onDetachedFromWindow();
	}

	public boolean isForceDragHighlightMode() {
		return forceDragHighlightMode;
	}

	public void setForceDragHighlightMode(boolean forceDragHighlightMode) {
		this.forceDragHighlightMode = forceDragHighlightMode;
	}

	@Override
	public boolean isFullyZoomedOut() {
		if (forceDragHighlightMode) {
			return true;
		}
		return super.isFullyZoomedOut();
	}

	@Override
	public boolean hasNoDragOffset() {
		if (forceDragHighlightMode) {
			return true;
		}
		return super.hasNoDragOffset();
	}
}

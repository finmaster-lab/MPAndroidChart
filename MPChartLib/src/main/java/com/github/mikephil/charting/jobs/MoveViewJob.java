
package com.github.mikephil.charting.jobs;

import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

import android.view.View;

/**
 * Created by Philipp Jahoda on 19/02/16.
 */
public class MoveViewJob extends ViewPortJob {

	private static ObjectPool<MoveViewJob> pool;

	static {
		pool = ObjectPool.create(2, new MoveViewJob(null, 0, 0, null, null));
		pool.setReplenishPercentage(0.5f);
	}

	public MoveViewJob(ViewPortHandler viewPortHandler, float xValue,
			float yValue, Transformer trans, View v) {
		super(viewPortHandler, xValue, yValue, trans, v);
	}

	public static MoveViewJob getInstance(ViewPortHandler viewPortHandler,
			float xValue, float yValue, Transformer trans, View v) {
		MoveViewJob result = pool.get();
		result.mViewPortHandler = viewPortHandler;
		result.xValue = xValue;
		result.yValue = yValue;
		result.mTrans = trans;
		result.view = v;
		return result;
	}

	public static void recycleInstance(MoveViewJob instance) {
		instance.mViewPortHandler=null;
		instance.view=null;
		instance.mTrans=null;
		pool.recycle(instance);
	}

	@Override
	public void run() {

		pts[0] = xValue;
		pts[1] = yValue;

		mTrans.pointValuesToPixel(pts);
		mViewPortHandler.centerViewPort(pts, view);

		this.recycleInstance(this);
	}

	@Override
	protected ObjectPool.Poolable instantiate() {
		return new MoveViewJob(mViewPortHandler, xValue, yValue, mTrans, view);
	}
}

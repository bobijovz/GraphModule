package jp.co.arkray.android.graphgenerator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;


/**
 * Created by USER on 1/29/2018.
 */

public class ImageGraphView extends android.support.v7.widget.AppCompatImageView {
    private GraphItem graphItem;
    private GraphSettings graph;

    public ImageGraphView(Context context) {
        super(context);
    }

    public ImageGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageGraphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setGraphItem(GraphItem graphItem, GraphSettings graph) {
        this.graphItem = graphItem;
        this.graph = graph;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //Graph grid generation
        GraphUtils.drawGraph(canvas,graph);


        super.onDraw(canvas);
    }

}

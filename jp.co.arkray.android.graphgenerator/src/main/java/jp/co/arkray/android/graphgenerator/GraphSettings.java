package jp.co.arkray.android.graphgenerator;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by USER on 1/30/2018.
 */

public class GraphSettings {

    public DisplayMetrics metrics;
    public float graphWidth;
    public float graphHeight;
    public float labelWidth;
    public float labelHeight;
    public float boxWidth;
    public float boxHeight;
    public int glucoseUnit;
    public int maxGlucoseLevel;
    public float maxInsulinBasalLevel;
    public float maxInsulinBolusLevel;
    public Boolean sumEnable = true;
    public Boolean isPumpEnable = false;
    public Boolean isGuideEnable = false;
    public Boolean isBGLabelEnable = false;

    public float LeftPoint;
    public float RightPoint;
    public float TopPoint;
    public float BottomPoint;
    public RectF GraphBorder;

    public RectF headerBanner;
    public RectF headerBanner2;

    public Paint grayThinPen;
    public Paint dGrayThickPen;
    public Paint blackTextPen;
    public Paint whiteTextPen;
    public Paint blackPen;
    public Paint ltGrayPen;

    public GraphSettings(DisplayMetrics metrics) {
        this.metrics = metrics;
    }

    public void setLabelParams(int labelWidth, int labelHeight){
        this.labelWidth = labelWidth > 0 ? GraphUtils.dpToPixels(labelWidth, metrics) : GraphUtils.dpToPixels(Constant.DEFAULT_GRAPH_LABEL_WIDTH,metrics);
        this.labelHeight = labelHeight > 0 ? GraphUtils.dpToPixels(labelHeight, metrics) : GraphUtils.dpToPixels(Constant.DEFAULT_GRAPH_LABEL_HEIGHT,metrics);
    }

    public void setGraphSettings( int glucoseUnit, int maxGlucoseLevel, float maxInsulinBasalLevel, float maxInsulinBolusLevel, Boolean sumEnable, Boolean isPumpEnable, Boolean isGuideEnable, Boolean isBGLabelEnable){
        this.glucoseUnit = glucoseUnit;
        this.maxGlucoseLevel = maxGlucoseLevel;
        this.maxInsulinBasalLevel = maxInsulinBasalLevel;
        this.maxInsulinBolusLevel = maxInsulinBolusLevel;
        this.sumEnable = sumEnable;
        this.isPumpEnable = isPumpEnable;
        this.isGuideEnable = isGuideEnable;
        this.isBGLabelEnable = isBGLabelEnable;
    }

    public void initPortrait(){
        graphWidth = metrics.widthPixels;
        graphHeight = metrics.widthPixels - (metrics.widthPixels / 3);

        LeftPoint = 0;
        RightPoint = metrics.widthPixels;

        TopPoint = GraphUtils.dpToPixels(sumEnable ? 45 : 25,metrics);
        BottomPoint = metrics.heightPixels - GraphUtils.dpToPixels(24,metrics) - GraphUtils.dpToPixels(120,metrics);
        GraphBorder = new RectF(
                LeftPoint,                //start left point of graph
                TopPoint,                //start top point of graph
                RightPoint,                  //end right point of graph
                BottomPoint                 //end bottom point of graph
        );
        boxHeight = GraphBorder.height()/6;
        boxWidth = GraphBorder.width()/12;
    }

    public void initLandscape(){
        graphWidth = metrics.widthPixels - (GraphUtils.dpToPixels((int)labelWidth, metrics) * 2);
        graphHeight = metrics.heightPixels - GraphUtils.dpToPixels(24,metrics);

        LeftPoint = 0;
        RightPoint = metrics.widthPixels - (GraphUtils.dpToPixels((int)labelWidth, metrics));

        TopPoint = GraphUtils.dpToPixels(sumEnable
                ? 45 : 25,metrics);
        BottomPoint = metrics.heightPixels - GraphUtils.dpToPixels(24,metrics) - GraphUtils.dpToPixels(120,metrics);
        GraphBorder = new RectF(
                LeftPoint,                //start left point of graph
                TopPoint,                //start top point of graph
                RightPoint,                  //end right point of graph
                BottomPoint                 //end bottom point of graph
        );
        boxHeight = GraphBorder.height()/6;
        boxWidth = GraphBorder.width()/12;
    }

    public void initPens(){
        grayThinPen = GraphUtils.createPen(Color.GRAY, GraphUtils.dpToPixels(1,metrics)/2);
        dGrayThickPen = GraphUtils.createPen(Color.DKGRAY, GraphUtils.dpToPixels(2,metrics));
        blackPen = GraphUtils.createPen(Color.BLACK, GraphUtils.dpToPixels(1,metrics));
        ltGrayPen = GraphUtils.createPen(Color.LTGRAY, GraphUtils.dpToPixels(1,metrics));

        whiteTextPen = GraphUtils.createTextPen(Color.WHITE, GraphUtils.spToPixels(12,metrics));
        blackTextPen = GraphUtils.createTextPen(Color.BLACK, GraphUtils.spToPixels(12,metrics));
    }

}

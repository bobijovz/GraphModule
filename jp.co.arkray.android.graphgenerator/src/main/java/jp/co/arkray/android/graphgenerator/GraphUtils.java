package jp.co.arkray.android.graphgenerator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by USER on 1/30/2018.
 */

public class GraphUtils {

    public static int dpToPixels(int dipValue, DisplayMetrics metrics) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public static int spToPixels(float dipValue, DisplayMetrics metrics) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dipValue, metrics);
    }

    public static Paint createPen(int color, int width_dp) {
        Paint pen = new Paint(Paint.ANTI_ALIAS_FLAG);
        pen.setColor(color);
        pen.setStyle(Paint.Style.STROKE);
        pen.setStrokeWidth(width_dp);
        pen.setTextSize(width_dp);
        return pen;
    }

    public static Paint createTextPen(int color, int size_sp) {
        Paint pen = new Paint(Paint.ANTI_ALIAS_FLAG);
        pen.setColor(color);
        pen.setTextSize(size_sp);
        return pen;
    }

    public static Rect getBounds(Paint pen, String val) {
        Rect bounds = new Rect();
        pen.getTextBounds(val, 0, val.length(), bounds);
        return bounds;
    }

    public static void drawGraph(Canvas canvas, GraphSettings graph) {
        canvas.drawColor(Color.parseColor("#ECEBED"));
        canvas.drawRoundRect(graph.GraphBorder, 7.0f, 7.0f, graph.dGrayThickPen);

        for (int x = 1; x <= 12; x++) {
            //Grid guide for odd time
            canvas.drawLine(
                    (x * graph.boxWidth) - (graph.boxWidth / 2),
                    graph.TopPoint - 10,
                    (x * graph.boxWidth) - (graph.boxWidth / 2),
                    graph.TopPoint,
                    graph.dGrayThickPen);
            if (x != 12) {
                //Grid guide for even time
                canvas.drawLine(
                        (x * graph.boxWidth),
                        graph.TopPoint - 10,
                        (x * graph.boxWidth),
                        graph.TopPoint,
                        graph.dGrayThickPen);
                //time grid label
                canvas.drawText(String.valueOf((x % 12) * 2),
                        (x * graph.boxWidth) - (GraphUtils.getBounds(graph.blackTextPen, String.valueOf((x % 12) * 2)).width() / 2),
                        graph.TopPoint - (GraphUtils.getBounds(graph.blackTextPen, String.valueOf((x % 12) * 2)).height()),
                        graph.blackTextPen);

                //Vertical grid lines
                canvas.drawLine(
                        (x * graph.boxWidth),
                        graph.TopPoint,
                        (x * graph.boxWidth),
                        graph.BottomPoint,
                        graph.grayThinPen);
            }
        }
        //horizontal grid lines
        for (int y = 0; y <= 6; y++) {
            if (y > 0 && y != 6)
                canvas.drawLine(
                        graph.LeftPoint,
                        (y * graph.boxHeight) + graph.TopPoint,
                        graph.RightPoint,
                        (y * graph.boxHeight) + graph.TopPoint,
                        graph.grayThinPen);
        }
    }

    /*public static void drawDailyTotal(Canvas canvas, GraphItem.DailyTotalData data, GraphSettings graph){
        String[] dailyData = new String[4];
        dailyData[0] = "Energy intake: " + String.valueOf(data.getEnergyIntake()) + "kcal  (No Input: " + data.getNoEnergyIntakeInput() + ")";
        dailyData[1] = "Carbohydrate: " + String.valueOf(data.getCarbohydrate()) + "g  (No Input: " + data.getNoCarbohydrateInput() + ")";
        dailyData[2] = data.getPumpEnabled() ? "Pump: "+ data.getPumpData() + "U (Basal: " + data.getBasalData() + "U Bolus: " + data.getBolusData() + "U)" : "Steps: " + data.getStepsData();
        dailyData[3] = data.getPumpEnabled() ? "Steps: " + data.getStepsData() : "";



        canvas.drawRect(headerBanner, headerBoxPen);

        //Content 1 Energy
        drawLabel(new GraphPoint(
                calculateX(day,0,1),
                (headerHeight / 2) - dpToPixels(15),
                dailyData[0]
        ));

        //Content 3 Carbo
        drawLabel(new GraphPoint(
                calculateX(day,0,1),
                headerHeight - dpToPixels(15),
                dailyData[1]
        ));

        //Content 2
        drawLabel(new GraphPoint(
                calculateX(day,12,0),
                (headerHeight / 2) - dpToPixels(15),
                dailyData[2]
        ));

        //Content 4
        if (!dailyData[3].equals(""))
            drawLabel(new GraphPoint(
                    calculateX(day,12,0),
                    headerHeight - dpToPixels(15),
                    dailyData[3]
            ));



    }*/


}

package jp.co.arkray.android.graphmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;

import jp.co.arkray.android.graphgenerator.Constant;
import jp.co.arkray.android.graphgenerator.GraphSettings;
import jp.co.arkray.android.graphgenerator.ImageGraphView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageGraphView iv = (ImageGraphView) findViewById(R.id.iv_graph);
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        GraphSettings graphSettings = new GraphSettings(metrics);
        graphSettings.setGraphSettings(Constant.GRAPH_LEVEL_TYPE_GLUCOSE,
                Constant.DEFAULT_GRAPH_MAX_GLUCOSE_LEVEL_MG,
                Constant.DEFAULT_GRAPH_MAX_INSULIN_BASAL_UNIT,
                Constant.DEFAULT_GRAPH_MAX_INSULIN_BOLUS_UNIT,
                false,
                false,
                false,
                false);
        graphSettings.setLabelParams(0,0);
        graphSettings.initPens();
        graphSettings.initLandscape();

        iv.setGraphItem(null, graphSettings);
        iv.postInvalidate();
    }
}

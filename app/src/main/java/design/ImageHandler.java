package design;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.weatherapp.R;

public class ImageHandler {
    private static int[] clear_condition = {1000};
    private static int[] cloudy_condition = {1003, 1006, 1009, 1030};
    private static int[] rainy_condition = {1063, 1135, 1147, 1150, 1153, 1168, 1171, 1180, 1183, 1186, 1189, 1192, 1195, 1198, 1201,
    1240, 1243, 1246, 1249, 1252, 1264};
    private static int[] snowy_condition = {1066, 1069, 1072, 1117, 1114, 1204, 1207, 1210, 1213, 1216, 1219, 1222, 1225, 1237, 1255,
    1258, 1261};
    private static int[] thunder_condition = {1273, 1087, 1276, 1279, 1282};

    protected static int[][] conditions = {
            clear_condition, cloudy_condition, rainy_condition, snowy_condition, thunder_condition};

    public static void setBackGround(int code, RelativeLayout layout, int is_day, ImageView curCondition)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < conditions[i].length; j++)
            {
                if (code == conditions[i][j])
                {
                    switch (i)
                    {
                        case 0: if (is_day == 1)
                        {
                            layout.setBackgroundResource(R.drawable.sunny_blur);
                            curCondition.setBackgroundResource(R.drawable.ic_condition_clear_day_white);
                            break;
                        } else
                        {
                            layout.setBackgroundResource(R.drawable.clear_night);
                            curCondition.setBackgroundResource(R.drawable.ic_condition_clear_night_white);
                            break;
                        }
                        case 1: layout.setBackgroundResource(R.drawable.cloudy_overcast_blur);
                                curCondition.setBackgroundResource(R.drawable.ic_condition_cloudy_white);
                        break;
                        case 2: layout.setBackgroundResource(R.drawable.rainy_blur);
                                curCondition.setBackgroundResource(R.drawable.ic_condition_rainy_white);
                        break;
                        case 3: layout.setBackgroundResource(R.drawable.snowy_sleet_blur);
                                curCondition.setBackgroundResource(R.drawable.ic_condition_snow_white);
                        break;
                        case 4: layout.setBackgroundResource(R.drawable.thunder_blur);
                                curCondition.setBackgroundResource(R.drawable.ic_condition_thunder_white);
                        break;
                        default: layout.setBackgroundResource(R.drawable.lowbgdefblur);
                                curCondition.setBackgroundResource(R.drawable.cloudy);
                        break;
                    }
                }
            }
        }
    }

    public static void setNonCoreCondition(int code, ImageView nonCoreCondition)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < conditions[i].length; j++)
            {
                if (code == conditions[i][j])
                {
                    switch (i)
                    {
                        case 0:
                            nonCoreCondition.setBackgroundResource(R.drawable.ic_condition_clear_day_white);
                            break;
                        case 1: nonCoreCondition.setBackgroundResource(R.drawable.ic_condition_cloudy_white);
                            break;
                        case 2: nonCoreCondition.setBackgroundResource(R.drawable.ic_condition_rainy_white);
                            break;
                        case 3: nonCoreCondition.setBackgroundResource(R.drawable.ic_condition_snow_white);
                            break;
                        case 4: nonCoreCondition.setBackgroundResource(R.drawable.ic_condition_thunder_white);
                            break;
                        default: nonCoreCondition.setBackgroundResource(R.drawable.cloudy);
                            break;
                    }
                }
            }
        }
    }

}

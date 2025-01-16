package com.vn.pickerview.configure;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.vn.pickerview.R;
import com.vn.pickerview.listener.CustomListener;
import com.vn.pickerview.listener.OnOptionsSelectChangeListener;
import com.vn.pickerview.listener.OnOptionsSelectListener;
import com.vn.pickerview.listener.OnTimeSelectChangeListener;
import com.vn.pickerview.listener.OnTimeSelectListener;
import com.vn.pickerview.view.WheelView;

import java.util.Calendar;

/**
 * Build Options
 * Created by xiaosongzeem on 2018/3/8.
 */

public class PickerOptions {

    //constant
    private static final int PICKER_VIEW_BTN_COLOR_NORMAL = 0xFF057dff;
    private static final int PICKER_VIEW_BG_COLOR_TITLE = 0xFFf5f5f5;
    private static final int PICKER_VIEW_COLOR_TITLE = 0xFF000000;
    private static final int PICKER_VIEW_BG_COLOR_DEFAULT = 0xFFFFFFFF;

    public static final int TYPE_PICKER_OPTIONS = 1;
    public static final int TYPE_PICKER_TIME = 2;

    public OnOptionsSelectListener optionsSelectListener;
    public OnTimeSelectListener timeSelectListener;
    public View.OnClickListener cancelListener;

    public OnTimeSelectChangeListener timeSelectChangeListener;
    public OnOptionsSelectChangeListener optionsSelectChangeListener;
    public CustomListener customListener;

    //options picker
    public String label1, label2, label3;//Unit characters
    public int option1, option2, option3;//Default selection
    public int x_offset_one, x_offset_two, x_offset_three;//X-axis offset

    public boolean cyclic1 = false;//Whether it loops or not, the default is no
    public boolean cyclic2 = false;
    public boolean cyclic3 = false;

    public boolean isRestoreItem = false; //When switching, the first item is restored


    //time picker
    public boolean[] type = new boolean[]{true, true, true, false, false, false};//Display type, default display: year, month, and day

    public Calendar date;//The time currently selected
    public Calendar startDate;//Start time
    public Calendar endDate;//Termination time
    public int startYear;
    public int endYear;

    public boolean cyclic = false;
    public boolean isScale = true;
    public boolean isLunarCalendar = false;//Whether or not to display the lunar calendar

    public String label_year, label_month, label_day, label_hours, label_minutes, label_seconds;
    public int x_offset_year, x_offset_month, x_offset_day, x_offset_hours, x_offset_minutes, x_offset_seconds;


    public PickerOptions(int buildType) {
        if (buildType == TYPE_PICKER_OPTIONS) {
            layoutRes = R.layout.pickerview_options;
        } else {
            layoutRes = R.layout.pickerview_time;
        }
    }

    //******* general field ******//
    public int layoutRes;
    public ViewGroup decorView;
    public int textGravity = Gravity.CENTER;
    public Context context;

    public String textContentConfirm;
    public String textContentCancel;
    public String textContentTitle;

    public int textColorConfirm = PICKER_VIEW_BTN_COLOR_NORMAL;
    public int textColorCancel = PICKER_VIEW_BTN_COLOR_NORMAL;
    public int textColorTitle = PICKER_VIEW_COLOR_TITLE;

    public int bgColorWheel = PICKER_VIEW_BG_COLOR_DEFAULT;
    public int bgColorTitle = PICKER_VIEW_BG_COLOR_TITLE;

    public int textSizeSubmitCancel = 17;
    public int textSizeTitle = 18;
    public int textSizeContent = 18;

    public int textColorOut = 0xFFa8a8a8;
    public int textColorCenter = 0xFF2a2a2a;
    public int dividerColor = 0xFFd5d5d5;
    public int outSideColor = -1;

    public float lineSpacingMultiplier = 1.6f;
    public boolean isDialog;

    public boolean cancelable = true;
    public boolean isCenterLabel = false;
    public Typeface font = Typeface.MONOSPACE;
    public WheelView.DividerType dividerType = WheelView.DividerType.FILL;
    public int itemsVisibleCount = 9;
    public boolean isAlphaGradient = false;
}

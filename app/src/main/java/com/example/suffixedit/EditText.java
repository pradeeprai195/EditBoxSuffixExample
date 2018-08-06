package com.example.suffixedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;

public class EditText extends AppCompatEditText {
    TextPaint mTextPaint = new TextPaint();
    String mSuffix = " years";

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTextPaint.setTextSize(getTextSize());
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void setSuffix(String s) {
        mSuffix = s;
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);

        String text = getText().toString();
        int xSuffix = 0;

        if (text.length() == 0) {
            //mTextPaint.setColor(getResources().getColor(R.color.colorPrimary));
            mTextPaint.setColor(getCurrentHintTextColor());
            xSuffix = (int) mTextPaint.measureText(getHint().toString()) + getPaddingLeft();
        } else {
            xSuffix = (int) mTextPaint.measureText(text) + getPaddingLeft();
            mTextPaint.setColor(getCurrentTextColor());
            //mTextPaint.setColor(getResources().getColor(R.color.colorPrimary));
        }

        //c.drawText(mSuffix, xSuffix, getMeasuredHeight() - getPaddingBottom() - getPaddingTop(), mTextPaint);
        //c.drawText(mSuffix, c.getWidth() / 2, ((c.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2)), mTextPaint);

        c.drawText(mSuffix, xSuffix, ((c.getHeight() / 2) - ((mTextPaint.descent() + mTextPaint.ascent()) / 2)), mTextPaint);
    }
}

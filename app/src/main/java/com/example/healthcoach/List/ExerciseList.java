package com.example.healthcoach.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healthcoach.Models.ExerciseModel;
import com.example.healthcoach.R;

import java.util.List;

public class ExerciseList extends ArrayAdapter<ExerciseModel> {

    private Activity context;
    private List<ExerciseModel> exerciseModelList;

    public ExerciseList( Activity context, List<ExerciseModel> exerciseModelList) {
        super(context, R.layout.list_layout_exercise);
        this.context = context;
        this.exerciseModelList = exerciseModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View  listViewItem =inflater.inflate(R.layout.list_layout_exercise,null,true);
        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textViewExerName);
        TextView textViewCalori=(TextView)listViewItem.findViewById(R.id.textViewCalorie);

        ExerciseModel model =exerciseModelList.get(position);

        textViewCalori.setText(model.getCalorieBurned());
        textViewName.setText(model.getExercise());

        return listViewItem;
    }
}

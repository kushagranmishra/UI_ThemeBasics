package kushagra.digipodium.basics1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Switch swTheme = view.findViewById(R.id.swTheme);
        final TextInputEditText textInput=view.findViewById(R.id.textInput);
        final CheckBox cbBox = view.findViewById(R.id.cbBox);
        RadioButton rbLemon = view.findViewById(R.id.rbLemon);
        RadioButton rbPineapple = view.findViewById(R.id.rbPineapple);
        RadioButton rbOrange = view.findViewById(R.id.rbOrange);
        SeekBar seekBar=view.findViewById(R.id.seekBar);
        final SeekBar seekB=view.findViewById(R.id.seekB);
        RatingBar ratingBar=view.findViewById(R.id.ratingBar);
        final CardView cardView=view.findViewById(R.id.cardView);
        final TextView textView=view.findViewById(R.id.textView);
        final ProgressBar progressBar=view.findViewById(R.id.progressBar);
        final FloatingActionButton btnPower=view.findViewById(R.id.btnPower);
        RadioGroup rgFruit=view.findViewById(R.id.rgFruit);
        swTheme.setChecked(true);
        cbBox.setEnabled(false);
        progressBar.setVisibility(View.INVISIBLE);
textView.setText("this is a simple message for users");
swTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @SuppressLint("ResourceAsColor")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(isChecked)
{
    cardView.setCardBackgroundColor(Color.WHITE);
}
else
{
    cardView.setCardBackgroundColor(Color.parseColor("#89ff93"));
}
    }
});
        rgFruit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbLemon:
                            textView.setText("you have selected lemon");
                            break;
                    case R.id.rbOrange:
                        textView.setText("you have selected orange");
                        break;
                    case R.id.rbPineapple:
                        textView.setText("you have selected pineapple");
                        break;
                }
            }
        });
        seekB.setProgress(0);
        seekB.setMax(100);
seekB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
textInput.setText(String.valueOf(progress) );
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    btnPower.animate().rotationY(360*100).setDuration(1000).start();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
ratingBar.setRating(2.5f);
ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if (rating == 5)
        {
            cbBox.setEnabled(true);
            progressBar.setVisibility(View.GONE);
        }
        if (rating ==0 )
        {
            cbBox.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
        }
    }
});
}
}
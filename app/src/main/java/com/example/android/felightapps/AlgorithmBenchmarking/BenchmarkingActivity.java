package com.example.android.felightapps.AlgorithmBenchmarking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.felightapps.R;

public class BenchmarkingActivity extends AppCompatActivity {

    private EditText mArraySizeEditText;

    private RadioGroup mAlgorithmCaseGroup;
    private RadioButton mBestCaseRadio;
    private RadioButton mAverageCaseRadio;
    private RadioButton mWorstCaseRadio;

    private TextView mGeneratedArrayTextView;

    private TextView mBubbleSortTextView;
    private TextView mSelectionSortTextView;
    private TextView mInsertionSortTextView;
    private TextView mMergeSortTextView;
    private TextView mQuickSortTextView;

    private Button mBubbleSortBtn;
    private Button mSelectionSortBtn;
    private Button mInsertionSortBtn;
    private Button mMergeSortBtn;
    private Button mQuickSortBtn;
    private Button mBenchmarkAllBtn;
    private Button mStartOverBtn;

    private int size;
    private int[] mArray;
    private int[] mDupArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmarking);

        mArraySizeEditText = (EditText) findViewById(R.id.etSizeOfArray);

        mAlgorithmCaseGroup = (RadioGroup) findViewById(R.id.rgAlgorithmCase);
        mBestCaseRadio = (RadioButton) findViewById(R.id.btnBestCase);
        mAverageCaseRadio = (RadioButton) findViewById(R.id.btnAverageCase);
        mWorstCaseRadio = (RadioButton) findViewById(R.id.btnWorstCase);

        mGeneratedArrayTextView = (TextView) findViewById(R.id.tvAlgorithmCase);

        mBubbleSortBtn = (Button) findViewById(R.id.btnBubbleSort);
        mSelectionSortBtn = (Button) findViewById(R.id.btnSelectionSort);
        mInsertionSortBtn = (Button) findViewById(R.id.btnInsertionSort);
        mMergeSortBtn = (Button) findViewById(R.id.btnMergeSort);
        mQuickSortBtn = (Button) findViewById(R.id.btnQuickSort);
        mBenchmarkAllBtn = (Button) findViewById(R.id.btnBenchmarkAll);
        mStartOverBtn = (Button) findViewById(R.id.btnStartOver);

        mBubbleSortTextView = (TextView) findViewById(R.id.tvBubbleSortTime);
        mSelectionSortTextView = (TextView) findViewById(R.id.tvSelectionSortTime);
        mInsertionSortTextView = (TextView) findViewById(R.id.tvInsertionSortTime);
        mMergeSortTextView = (TextView) findViewById(R.id.tvMergeSortTime);
        mQuickSortTextView = (TextView) findViewById(R.id.tvQuickSortTime);

        size = 0;

        getAlgorithmCase();
        assignListeners();
    }

    public void getAlgorithmCase() {
        mAlgorithmCaseGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.btnBestCase:
                        try {
                            size = Integer.parseInt(mArraySizeEditText.getText().toString());
                            mArray = GenerateArrays.getNaturalNumbersArray(size);
                            mDupArray = new int[size];
                            mGeneratedArrayTextView.setText(
                                    "Sorted array of size " + size
                                            + " is generated");
                            break;
                        } catch (NumberFormatException e) {
                            mGeneratedArrayTextView.setText("Please enter a non zero number for size");
                        }

                    case R.id.btnAverageCase:
                        try {
                            size = Integer.parseInt(mArraySizeEditText.getText().toString());
                            mArray = GenerateArrays.getRandomArray(size);
                            mDupArray = new int[size];
                            mGeneratedArrayTextView.setText(
                                    "Random array of size " + size
                                            + " is generated");
                            break;
                        } catch (NumberFormatException e) {
                            mGeneratedArrayTextView.setText("Please enter a non zero number for size");
                        }

                    case R.id.btnWorstCase:
                        try {
                            size = Integer.parseInt(mArraySizeEditText.getText().toString());
                            mArray = GenerateArrays.getReverseArray(size);
                            mDupArray = new int[size];
                            mGeneratedArrayTextView.setText(
                                    "Sorted array in descending order of size " + size
                                            + " is generated");
                            break;
                        } catch (NumberFormatException e) {
                            mGeneratedArrayTextView.setText("Please enter a non zero number for size");
                        }
                }
            }
        });
    }

    public void assignListeners() {
        mBubbleSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubbleSort();
            }
        });

        mSelectionSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionSort();
            }
        });

        mInsertionSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertionSort();
            }
        });

        mMergeSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mergeSort();
            }
        });

        mQuickSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quickSort();
            }
        });

        mBenchmarkAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubbleSort();
                selectionSort();
                insertionSort();
                mergeSort();
                quickSort();
            }
        });

        mStartOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOver();
            }
        });
    }

    private void bubbleSort() {
        try {
            GenerateArrays.initDupArray(mArray, mDupArray);
            long time = SortingAlgos.bubbleSort(mDupArray);
            mBubbleSortTextView.setText(time + "ms");
        } catch (Exception e) {
            Toast.makeText(this, "Please provide a non zero size for the array", Toast.LENGTH_SHORT).show();
        }

    }

    private void selectionSort() {
        try {
            GenerateArrays.initDupArray(mArray, mDupArray);
            long time = SortingAlgos.selectionSort(mDupArray);
            mSelectionSortTextView.setText(time + "ms");
        } catch (Exception e) {
            Toast.makeText(this, "Please provide a non zero size for the array", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertionSort() {
        try {
            GenerateArrays.initDupArray(mArray, mDupArray);
            long time = SortingAlgos.insertionSort(mDupArray);
            mInsertionSortTextView.setText(time + "ms");
        } catch (Exception e) {
            Toast.makeText(this, "Please provide a non zero size for the array", Toast.LENGTH_SHORT).show();
        }
    }

    private void mergeSort() {
        try {
            GenerateArrays.initDupArray(mArray, mDupArray);
            long time = SortingAlgos.mergeSortHelper(mDupArray);
            mMergeSortTextView.setText(time + "ms");
        } catch (Exception e) {
            Toast.makeText(this, "Please provide a non zero size for the array", Toast.LENGTH_SHORT).show();
        }
    }

    private void quickSort() {
        try {
            GenerateArrays.initDupArray(mArray, mDupArray);
            long time = SortingAlgos.quickSortHelper(mDupArray);
            mQuickSortTextView.setText(time + "ms");
        } catch (Exception e) {
            Toast.makeText(this, "Please provide a non zero size for the array", Toast.LENGTH_SHORT).show();
        }
    }

    private void startOver() {
        mArraySizeEditText.setText(String.valueOf(""));
        size = 0;
        mArray = null;
        mDupArray = null;
        mAlgorithmCaseGroup.clearCheck();
        mAlgorithmCaseGroup.check(R.id.btnAverageCase);
        mGeneratedArrayTextView.setText("");
        mBubbleSortTextView.setText("");
        mSelectionSortTextView.setText("");
        mInsertionSortTextView.setText("");
        mMergeSortTextView.setText("");
        mQuickSortTextView.setText("");
    }


}






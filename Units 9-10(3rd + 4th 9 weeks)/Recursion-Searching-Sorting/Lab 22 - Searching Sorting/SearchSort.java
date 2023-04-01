import java.util.*;
import java.util.Arrays;

class SearchSort {

  private int[] nums;

  public SearchSort(int[] nums) {
    this.nums = nums;
  }

  public SearchSort(int size) {
    this.nums = new int[size];
  }

  public void initArray() {
    Random rng = new Random();
    for (int i = 0; i < this.nums.length; i++) {
      nums[i] = rng.nextInt(1000) + 1;
    }
    for (int num : this.nums) {
      System.out.print(num + " ");
    }
  }

  private void swap(int i, int j) {
    int temp = this.nums[i];
    this.nums[i] = this.nums[j];
    this.nums[j] = temp;
  }

  // Linear Search Implementations
  public int linearSearch(int key) {
    for (int i = 0; i < this.nums.length; i++) {
      if (nums[i] == key) {
        return i;
      }
    }
    return -1;
  }

  public int linearSearchRecur(int key) {
    return linearSearchRecur(key, 0);
  }

  private int linearSearchRecur(int key, int index) {
    if (this.nums[index] == key) {
      return index;
    }
    if (index == this.nums.length - 1 && this.nums[index] != key) {
      return -1;
    } else {
      return linearSearchRecur(key, index + 1);
    }
  }

  //Binary Search Implementations
  public int binarySearch(int key) {
    Arrays.sort(this.nums);
    int low = 0;
    int high = this.nums.length - 1;
    while (low < high) {
      int middle = (low + high) / 2;
      if (this.nums[middle] == key) {
        return middle;
      }
      if (key < this.nums[middle]) {
        high = middle - 1;
      }
      if (key > this.nums[middle]) {
        low = middle + 1;
      }
    }
    return -1;
  }

  public int binarySearchRecursive(int key) {
    return this.binarySearchRecursive(key, ((0 + this.nums.length - 1) / 2));
  }

  public int binarySearchRecursive(int key, int index) {
    if (this.nums[index] == key) {
      return index;
    } else {
      int low = 0;
      int high = this.nums.length - 1;
      if (key < this.nums[index]) {
        high = index - 1;
      } else {
        low = index + 1;
      }
      return binarySearchRecursive(key, ((low + high) / 2));
    }
  }

  // Bubble sort implementation
  public void bubbleSort() {
    for (int i = 0; i < this.nums.length - 1; i++) {
      for (int j = 0; j < this.nums.length - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          this.swap(j, j + 1);
        }
      }
    }
    for (int n : this.nums) {
      System.out.print(n + " ");
    }
  }

  // Selection Sort Implementation
  public int minElem(int start, int end) {
    int[] target = Arrays.copyOfRange(this.nums, start, end);
    int minimum = 9999;
    for (int i = 0; i < target.length; i++) {
      if (target[i] < minimum) {
        minimum = target[i];
      }
    }
    return minimum;
  }

  public void selectionSort() {
    for (int i = 0; i < this.nums.length; i++) {
      int min = minElem(0, this.nums.length - 1);
      this.swap(this.nums[0], min);
      for (int j = i + 1; j < this.nums.length; j++) {
        int newMin = minElem(j, this.nums.length - 1);
        this.swap(this.nums[0], newMin);
      }
    }
    for (int n : this.nums) {
      System.out.print(n + " ");
    }
  }

  //Insertion sort implementation
  public void insertionSort() {
    for (int i = 0; i < this.nums.length - 1; i++) {
      int j = i; // keep a track of the current element
      while (j > 0 && this.nums[j - 1] > this.nums[j]) {
        // if a single digit number is 3 spaces away from idx 0, we want to perform 3 swaps until it is in the right position
        this.swap(j, j + 1);
        j -= 1;
      }
    }
    for (int n : this.nums) {
      System.out.print(n + " ");
    }
  }

  // Merge sort implementation
  public void mergeSort(int[] arr, int start, int end) {
    if (start > end) {
      return;
    } else {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid); // first half of the array
      mergeSort(arr, mid + 1, end); // second half of the array
      merge(arr, start, mid, end); // merge the final two sorted halves into one single array
    }
  }

  public void merge(int[] arr, int start, int middle, int end) {
    int[] tempArr = new int[arr.length];
    int i = start;
    int j = middle + 1;
    int k = end;

    while (i <= middle && j <= end) {
      if (arr[i] < arr[j]) {
        tempArr[k] = arr[i];
        i++;
      } else {
        tempArr[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i <= middle) {
      tempArr[k] = arr[i];
      i++;
      k++;
    }

    while (j <= end) {
      tempArr[k] = arr[j];
      j++;
      k++;
    }

    for (i = start; i < end; i++) {
      arr[i] = tempArr[i];
    }
  }
}

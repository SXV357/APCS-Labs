class SoundLabProbs {
    
    public SoundLabProbs(){

    }

    public void triangle(int n){
        for (int i = 0; i <= n; i++){
            for (int j = 0; j < i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public int lastIndexOf(int[] nums, int value){
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == value){
                index = i;
            }
        }
        return index;
    }

    public int range(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int range = max - min;
        return range;
    }

    public int minDifference(int[] nums){
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            int diff = Math.abs(nums[i] - nums[i+1]);
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public int priceIsRight(int[] bids, int price){
        int closest = -1;
            for(int i = 0; i < bids.length; i++){
                if(bids[i] <= price){
                    if(closest == -1){
                        closest = bids[i];
                    } else if(bids[i] > closest){
                        closest = bids[i];
                    }
                }
            }
            return closest;
    }

    public int[] productExceptSelf(int[] nums){
        int[] newArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            newArr[i] = product;
        }
        return newArr;
    }

}

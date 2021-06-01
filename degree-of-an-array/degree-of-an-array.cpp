class Solution {
public:
  int findShortestSubArray(vector<int>& nums) {
    unordered_map<int, pair<int, int>> fl;
    unordered_map<int, int> cnt;
    int deg = 0;
     
    for(int i=0;i<nums.size();i++){
      deg = max(deg, ++cnt[nums[i]]);
      fl[nums[i]].second = i;
    }
   
    for(int i=nums.size()-1;i>=0;i--)
      fl[nums[i]].first = i;
     
    int ans = nums.size();
    for(auto k: cnt){
      if(k.second != deg)
        continue;
       
      int s = fl[k.first].first;
      int e = fl[k.first].second;
      ans = min(ans, e-s+1);
    }
     
    return ans;
  }
};
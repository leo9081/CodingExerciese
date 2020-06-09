package com.yi.interviewquestions.Amazon;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");

        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

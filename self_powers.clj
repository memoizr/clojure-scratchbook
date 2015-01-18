(defn self-pow [x]
  (loop [i x n 1]
    (if (= i 0) n
      (recur (dec i) (*' x n)))))

(time (take-last 10 (str (reduce + (map self-pow (range 1 1001))))))
(time (take-last 10 (str (reduce + (map self-pow (range 1 1001))))))

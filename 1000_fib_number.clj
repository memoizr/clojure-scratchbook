(defn fib [top]
  (loop [a 0 b 1 i 0]
       (if (= i top)
         b
         (recur b (+' a b) (inc i)) )
       ))

(defn get-nth-long [n]
  (loop [i 0 acc 0]
    (if (= acc n)  i
      (recur (inc i) (count (str (fib i)))))))

(println (get-nth-long 1000))

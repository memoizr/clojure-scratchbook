(defn collatz [n]
  ((fn [x acc]
    (cond
          (<= x 1) (inc (count acc))
          (zero? (rem x 2))
          (recur (/ x 2) (cons x acc))
          :else (recur (inc (* 3 x)) (cons x acc)))) n ()))

;(defn build-list [n]
  ;(into (sorted-set)
    ;(reduce concat
            ;(for [x (range 1 10000)]
              ;[(collatz x)]))))

(defn build-list [n]
  (loop [i 1 acc {}]
    (if (= i n)
      (apply max-key val acc)
      (recur (inc i) (merge (hash-map i (collatz i)) acc)))))

(defn build-list2 [n]
  (loop [i 1 acc ()]
    (if (= i n)
      acc
      (recur (inc i) (list (apply max (cons (collatz i) acc)))))))

(defn build-list1 [n]
  (loop [i 1 acc 0 result 0]
    (cond
      (= i n) [result acc]
      (> (collatz i) acc) (recur (inc i) (collatz i) i)
      :else (recur (inc i) acc result))))

(time (build-list1 1000000))


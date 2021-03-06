


(defn collatz [n]
  ((fn [x acc]
    (cond
          (<= x 1) (inc (count acc))
          (zero? (rem x 2))
          (recur (/ x 2) (cons x acc))
          :else (recur (inc (* 3 x)) (cons x acc)))) n ()))

(defn build-list1 [n]
  (loop [i 1 acc 0 result 0]
    (cond
      (= i n) [result acc]
      (> (collatz i) acc) (recur (inc i) (collatz i) i)
      :else (recur (inc i) acc result))))

;(println (build-list1 10000))



;================================
;================================

; Sombody else's implementation from the forums.
; It is also correct but it runs about 4 times slower.

(defn collatz1 [start]
  (cons start ((defn sub-collatz [n]
                 (cond (= 1 n) nil
                       (zero? (mod n 2)) (cons (/ n 2) (lazy-seq (sub-collatz (/ n 2))))
                 :else (cons (inc (* n 3)) (lazy-seq (sub-collatz (inc (* n 3)))))))
               start)))

(defn f
  ([c] c)
  ([c1 c2] (if (> (count c1) (count c2)) c1 c2)))

(time (build-list1 1000000))
(time (first (reduce f (map collatz1 (range 2 1000001)))))
(time (build-list1 1000000))
(time (first (reduce f (map collatz1 (range 2 1000001)))))


;================================
;================================

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



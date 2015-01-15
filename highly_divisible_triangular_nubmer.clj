(defn number-divisors [number]
  (count (filter (fn [n] (= 0 (mod number n))) (range 1 (inc number)))))

(defn divisors [n]
  (loop [x 1 total ()]
    (if (> x (/ n 2))
      (inc (count total))
      (if (= 0 (mod n x))
        (recur (inc x) (cons x total))
        (recur (inc x) total)))))

(defn tri
  ([] (tri 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (tri new-sum (inc n)))))))

;=====================================================
;=====================================================

(defn factors [n]
  (count (into (sorted-set)
        (reduce concat
                (for [x (range 1 (inc (Math/sqrt n))) :when (zero? (rem n x))]
                  [x (/ n x)])))))

(defn trignum [n]
  (loop [x n total 0]
    (if (= x 0) total
      (recur (dec x) (+ x total))
    )))

(def trignum-memo (memoize trignum))
(def factors-memo (memoize factors))

(defn trignum-by-divisor-memo [n]
  (loop [x 0 divisors 0]
    (if (>= divisors n)
      (trignum-memo x)
      (recur (inc x) (factors-memo (trignum-memo (inc x)))))))


(println (trignum-by-divisor-memo 500))



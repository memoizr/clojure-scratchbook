(defn sumall [coll]
  (reduce + coll))

(defn divisors [n]
  (let [mx (/ n 2)]
  (loop [x 1 total ()]
    (if (> x mx)
      total
      (if (= 0 (mod n x))
        (recur (inc x) (cons x total))
        (recur (inc x) total))))))

(def sumall-memo (memoize sumall))
(def divisors-memo (memoize divisors))

(defn sumdiv [x]
  (sumall-memo (divisors-memo x)))

(def sumdiv-memo (memoize sumdiv))

(defn amicable? [a b]
  (and
    (= (sumdiv-memo a) b)
    (= (sumdiv-memo b) a)))

(defn mapamicable []
  (for [x (range 10000) y (range x 10000) :when (and (not= x y) (amicable? x y))]
    [x y]))

(time (sumall (flatten (mapamicable))))


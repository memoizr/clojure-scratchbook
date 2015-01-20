(defn primefact
  ([n]
   (primefact n 2 '()))
  ([n candidate acc]
   (cond (<= n 1) (reverse acc)
         (zero? (rem n candidate))
           (recur (/ n candidate) candidate (cons candidate acc))
         :else (recur n (inc candidate) acc))))

(def primefactors (memoize primefact))

;(println (take 10 (filter #(= 2 (count %)) (map primefactors (range)))))

(defn prim [x cutoff]
  (let [n (primefactors x)]
    (and
      (= cutoff (count (into #{} n))))))

(def primate (memoize prim))

(defn func [cutoff]
  (for [n (range 10000) :when (let [a (primefactors n) b (primefactors (inc n)) c (primefactors (+ 2 n)) d (primefactors (+ 3 n))]
                              (and
                                (= cutoff (count a))
                                (= cutoff (count b))
                                (= cutoff (count c))
                                (= cutoff (count d))
                                (= (count (into #{} a)) (count a))
                                (= (count (into #{} d)) (count d))
                                (= (count (into #{} b)) (count b))
                                (= (count (into #{} c)) (count c))
                                ))]
     n))

(defn funcn [cutoff]
  (for [n (range 100000 250000) :when (and
                               (primate n cutoff)
                               (primate (+ 2 n) cutoff)
                               (primate (+ 3 n) cutoff)
                               (primate (inc n) cutoff))]
    n))

(defn funcn [cutoff]
  (loop [n 0 acc 0]
    (cond
      (= acc ) n
      (= (primate n) cutoff)
        (recur (inc n) (inc acc))
      (= (recur (inc) 0)

(println (funcn 4))

;(println (map #(primate % 2) (range 20)))

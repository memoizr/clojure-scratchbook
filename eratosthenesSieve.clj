(defn prime? [n]
  (every? #(pos? (rem n %)) (range 2 (Math/sqrt (inc n)))))

(defn naive-primes [n]
  (filter prime? (range 2 (inc n))))


(defn primes
  ([^long n]
   (let [not-prime (doto (boolean-array (inc n))
                     (aset 0 true)
                     (aset 1 true))
         primes (long-array (inc n))]
     (loop [p (int 0), i (int 2)]
       (if (<= i n)
         (if (aget ^booleans not-prime i)
           (recur p (inc i))
           (do
               (aset ^longs primes p i)
               (loop [j (* 2 i)]
                 (when (<= j n)
                   (aset ^booleans not-prime j true)
                   (recur (+ j i))))
               (recur (inc p) (inc i))))
         (take p primes))))))

(defn sieve [[xs ps]]
  (let [[p & more] xs]
    [(remove #(zero? (rem % p)) xs) (cons p ps)]))

(defn primes2 [n]
  (if (< n 2)
    []
    (->> [(range 2 (inc n)) nil]
         (iterate sieve)
         (drop-while #(< (ffirst %) (Math/sqrt n)))
         first
         (apply concat))))

(time (def b (primes 10000)))
(time (def c (primes2 10000)))
(time (def a (naive-primes 2000000)))

(println (reduce + a))
;(println b)
;(println c)

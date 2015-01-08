(defn primefactors
  ([n]
   (primefactors n 2 '()))
  ([n candidate acc]
   (cond (<= n 1) (reverse acc)
         (zero? (rem n candidate)) (recur (/ n candidate) candidate (cons candidate acc))
         :else (recur n (inc candidate) acc))))

(println (primefactors 600851475143))

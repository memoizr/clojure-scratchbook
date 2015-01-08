(def certainty 5)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) certainty))

(println (last (take 10001
      (filter prime?
              (take-nth 2
                        (range 1 Integer/MAX_VALUE))))))

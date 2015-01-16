(defn factorial [x]
  (loop [n x acc 1]
    (if (= 1 n) acc
    (recur (dec n) (*' acc n)))))

(defn sumall [x]
  (apply +
         (map #(Character/digit % 10) (str x))))


(println (sumall (factorial 100)))


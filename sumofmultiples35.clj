(defn multiples-collection [coll-range x y]
  (filter
    (fn [item] (or (= 0 (mod item x)) (= 0 (mod item y)))) (range 1 coll-range )))

(defn sumall [coll]
  (if (= coll ()) 0
    (+ (first coll) (sumall (rest coll)))))

(println (sumall '(1 2 3 4 5)))
(println (multiples-collection 10 3 5))
(println (sumall (multiples-collection 10 3 5)))
(println (sumall (multiples-collection 1000 3 5)))

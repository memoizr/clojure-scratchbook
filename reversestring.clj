(defn reversestr [x] (if (= x ()) "" (str (reversestr (rest x)) (first x) )))

(defn reverselst [x] (if (= x ()) () (flatten (list (reverselst (rest x)) (first x)))))

(def y "choo")
(def z "Flavio")

(println (reversestr y))
(println (reversestr z))
(println (reverselst (list 1 2 3 4)))

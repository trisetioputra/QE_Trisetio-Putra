echo "Enter a number:"
read number

for (( i=1; i<=$number; i++ ))
do
    if (( i % 2 == 0 ))
    then
      echo "$i is even"
    else
      echo "$i is odd"
    fi
done

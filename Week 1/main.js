// Fungsi untuk mengecek apakah sebuah angka adalah bilangan prima
function isPrime(num) {
    if (num <= 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

// Fungsi utama untuk menghitung total sesuai dengan kriteria
function calculateTotal(N) {
    let total = 0;

    for (let i = 1; i <= N; i++) {
        if (isPrime(i)) {
            continue; // Abaikan angka prima
        } else if (i % 2 === 0) {
            total += i / 2; // Jika habis dibagi 2, bagi 2 dulu
        } else if (i % 3 === 0) {
            total += i * 3; // Jika habis dibagi 3, kalikan dengan 3
        } else {
            total += i; // Tambah angka seperti biasa
        }
    }

    return total;
}

// Contoh penggunaan
const N = 5;
const result = calculateTotal(N);
console.log(`Output = ${result}`);

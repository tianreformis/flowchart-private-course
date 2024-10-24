#include <iostream>
#include <cmath>

// Fungsi untuk memeriksa apakah suatu angka adalah angka prima
bool isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}

int main() {
    int N=5;
 

    int total = 0;

    for (int i = 1; i <= N; ++i) {
        if (isPrime(i)) {
            continue; // angka prima tidak dijumlahkan
        }
        else if (i % 2 == 0) {
            total += i / 2; // Jika angka habis dibagi 2, tambahkan i/2
        }
        else if (i % 3 == 0) {
            total += i * 3; // Jika angka habis dibagi 3, tambahkan i*3
        }
        else {
            total += i; // Jika angka tidak memenuhi kondisi, tambahkan i
        }
    }

    std::cout << "Total: " << total << std::endl;

    return 0;
}
